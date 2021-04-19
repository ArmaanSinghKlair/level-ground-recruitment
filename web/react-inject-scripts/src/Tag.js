function Tag({ value, onClick }) {
  return (
    <div className="tag d-flex" onClick={onClick}>
      <span className="badge bg-secondary">{value} </span>
      <button className="btn-close" aria-label="Close"></button>
    </div>
  );
}

export default Tag;
